import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useSearchParams } from 'react-router-dom';
import {
  setOrderData,
  showModal,
  closeModal,
  fetchTrackingThunk,
} from '../../redux/orderActionsSlice';
import './styles.css';

function formatDate(dateString) {
  const date = new Date(dateString);
  if (dateString === 'N/A' || isNaN(date.getTime())) return 'N/A';
  return date.toISOString().split('T')[0];
}

function OrderActions() {
  const [searchParams] = useSearchParams();
  const dispatch = useDispatch();
  const { orderData, modal, tracking } = useSelector((state) => state.orderActions);

  useEffect(() => {
    dispatch(
      setOrderData({
        id: searchParams.get('orderId') || 'N/A',
        status: searchParams.get('status') || 'N/A',
        total: searchParams.get('total') || 'N/A',
        date: formatDate(searchParams.get('date') || 'N/A'),
      })
    );
  }, [searchParams, dispatch]);

  const trackPackage = async () => {
    try {
      const result = await dispatch(fetchTrackingThunk(orderData.id)).unwrap();
      dispatch(
        showModal({
          title: 'Tracking Info',
          message: `Tracking ID: ${result.Shipment.shipmentID || 'N/A'}\nStatus: ${
            result.Shipment.shipmentStatus || 'N/A'
          }\nShipped Date: ${formatDate(result.Shipment.shippedDate || '')}`,
        })
      );
    } catch (error) {
      dispatch(showModal({ title: 'Error', message: 'Failed to fetch tracking info' }));
    }
  };

  const cancelOrder = () => {
    if (orderData.status.toLowerCase() === 'shipped') {
      dispatch(showModal({ title: 'Cancel Order', message: 'Order already shipped. Please request a return.' }));
    } else {
      dispatch(showModal({ title: 'Cancel Order', message: 'Are you sure you want to cancel this order?' }));
    }
  };

  const returnOrder = () => {
    if (orderData.status.toLowerCase() !== 'delivered') {
      dispatch(showModal({ title: 'Return Order', message: 'You can only return an order that has been delivered.' }));
    } else {
      dispatch(showModal({ title: 'Return Order', message: 'Return process initiated. We’ll email you return instructions.' }));
    }
  };

  return (
    <div className="container">
      <div className="header">
        <h1>Order Actions</h1>
        <p>Manage your order with the actions below</p>
      </div>

      <div className="section">
        <div className="order-info">
          <div className="order-info-title">Order Information</div>
          <div className="order-details">
            <div className="order-detail"><span className="order-label">Order ID</span><span className="order-value">{orderData.id}</span></div>
            <div className="order-detail"><span className="order-label">Status</span><span className={`status-badge ${orderData.status.toLowerCase() === 'shipped' ? 'status-shipped' : 'status-processing'}`}>{orderData.status}</span></div>
            <div className="order-detail"><span className="order-label">Total</span><span className="order-value">{orderData.total}</span></div>
            <div className="order-detail"><span className="order-label">Date</span><span className="order-value">{orderData.date}</span></div>
          </div>
        </div>

        <h2 className="section-title">Available Actions</h2>
        <div className="actions-grid">
          <div className="action-card" onClick={trackPackage}>
            <div className="action-icon">📦</div><div className="action-title">Track Package</div>
            <button className="action-btn">Track Now</button>
          </div>
          <div className="action-card" onClick={() => dispatch(showModal({ title: 'Seller Feedback', message: 'Thank you for your feedback to the seller!' }))}>
            <div className="action-icon">⭐</div><div className="action-title">Seller Feedback</div>
            <button className="action-btn">Submit</button>
          </div>
          <div className="action-card" onClick={() => dispatch(showModal({ title: 'Product Feedback', message: 'Leave feedback for the product you received.' }))}>
            <div className="action-icon">📝</div><div className="action-title">Product Feedback</div>
            <button className="action-btn">Review</button>
          </div>
          <div className="action-card" onClick={() => dispatch(showModal({ title: 'View Items', message: `Viewing items for Order ID: ${orderData.id}` }))}>
            <div className="action-icon">🛍️</div><div className="action-title">View Items</div>
            <button className="action-btn">View</button>
          </div>
          <div className="action-card" onClick={() => dispatch(showModal({ title: 'Reorder Items', message: `Reordering items for Order ID: ${orderData.id}` }))}>
            <div className="action-icon">🔄</div><div className="action-title">Reorder</div>
            <button className="action-btn">Reorder</button>
          </div>
          <div className="action-card" onClick={returnOrder}>
            <div className="action-icon">🧾</div><div className="action-title">Return Order</div>
            <button className="action-btn">Return</button>
          </div>
          <div className="action-card" onClick={cancelOrder}>
            <div className="action-icon">❌</div><div className="action-title">Cancel Order</div>
            <button className="action-btn">Cancel</button>
          </div>
        </div>
      </div>
{tracking.loading && <div className="loader">Loading tracking info...</div>}

      {modal.visible && (
        <div className="modal" onClick={() => dispatch(closeModal())}>
          <div className="modal-content" onClick={(e) => e.stopPropagation()}>
            <span className="close" onClick={() => dispatch(closeModal())}>&times;</span>
            <h2>{modal.title}</h2>
            <p>{modal.message}</p>
            <button className="action-btn" onClick={() => dispatch(closeModal())}>Close</button>
          </div>
        </div>
      )}
    </div>
  );
}

export default OrderActions;