import React, { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { fetchOrdersThunk, setMonths } from "../../redux/orderSlice";
import { formatDate, getQueryParam, setQueryParam } from "../../utils/helpers";
import { useNavigate } from "react-router-dom";
import "./orderdashboard.css";

function OrderDashboard() {
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const { months, orders } = useSelector((state) => state.orders);

  const validMonths = ["1", "2", "3", "4", "5", "6", "12"];

  useEffect(() => {
    const param = getQueryParam("months");
    if (!validMonths.includes(param)) {
      dispatch(setMonths("6"));
    } else {
      dispatch(setMonths(param));
    }
  }, []);

  useEffect(() => {
    setQueryParam("months", months);
    dispatch(fetchOrdersThunk(months));
  }, [months, dispatch]);

  const handleChange = (e) => dispatch(setMonths(e.target.value));

  const viewDetails = (orderId) => navigate(`/details?orderId=${orderId}`);
  const viewShipment = (orderId) => navigate(`/shipment?orderId=${orderId}`);
  const viewActions = (order) => {
    const { orderId, orderStatus, orderTotal, orderDate } = order;
    navigate(
      `/actions?orderId=${orderId}&status=${orderStatus}&total=${orderTotal}&date=${orderDate}`
    );
  };

  return (
    <div className="container">
      <div className="header">
        <h1>Orders Management Dashboard</h1>
      </div>

      <div className="filter-section">
        <div className="filter-container">
          <label className="filter-label">Filter by months:</label>
          <div className="dropdown">
            <select value={months} onChange={handleChange}>
              {validMonths.map((m) => (
                <option key={m} value={m}>
                  Last {m} month(s)
                </option>
              ))}
            </select>
          </div>
        </div>
      </div>

      <div className="orders-section">
        <div className="orders-grid">
          {orders.length === 0 ? (
            <div className="no-orders">
              <h3>No Orders Found</h3>
            </div>
          ) : (
            orders.map((order) => (
              <div key={order.orderId} className="order-card">
                <div className="order-header">
                  <div className="order-id">{order.orderId}</div>
                  <div className="order-date"> <i className="fi fi-sr-calendar"></i>  {formatDate(order.orderDate)}</div>
                </div>
                <div className="order-body">
                  <div className="order-info">
                    <div className="info-item">
                      <span className="info-label">
                        <i className="fi fi-sr-user"></i>
                      </span>
                      <span className="info-value">{order.name}</span>
                    </div>
                    <div className="info-item">
                      <span className="info-label">Amount</span>
                      <span className="info-value">₹{order.orderTotal}</span>
                    </div>
                    <div className="info-item">
                      <span className="info-label">Items</span>
                      <span className="info-value">{order.items}</span>
                    </div>
                  </div>

                  <div className={`status ${order.orderStatus.toLowerCase()}`}>
                    {order.orderStatus}
                  </div>

                  <div className="order-actions">
                    <button
                      className="action-btn btn-details"
                      onClick={() => viewDetails(order.orderId)}
                    >
                      Details
                    </button>
                    <button
                      className="action-btn btn-shipment"
                      onClick={() => viewShipment(order.orderId)}
                    >
                      Shipment
                    </button>
                    <button
                      className="action-btn btn-more"
                      onClick={() => viewActions(order)}
                    >
                      More
                    </button>
                  </div>
                </div>
              </div>
            ))
          )}
        </div>
      </div>
    </div>
  );
}

export default OrderDashboard;
