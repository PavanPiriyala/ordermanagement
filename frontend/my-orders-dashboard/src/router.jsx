import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import OrderDashboard from './components/OrderDashboard';
import OrderActions from './components/OrderActions';
import OrderDetails from './components/OrderDetails';
import ShipmentDetails from './components/ShipmentDetails';

const Router = () => (
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<OrderDashboard />} />
      <Route path="/actions" element={<OrderActions />} />
      <Route path="/details" element={<OrderDetails />} />
      <Route path="/shipment" element={<ShipmentDetails />} />
    </Routes>
  </BrowserRouter>
);

export default Router;