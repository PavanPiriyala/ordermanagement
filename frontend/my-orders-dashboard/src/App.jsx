import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import OrderDashboard from './components/OrderDashboard/OrderDashboard';
import OrderActions from './components/OrderActions/OrderActions';
import OrderDetails from './components/OrderDetails/OrderDetails';
import ShipmentDetails from './components/ShipmentDetails/ShipmentDetails';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<OrderDashboard />} />
        <Route path="/actions" element={<OrderActions />} />
        <Route path="/details" element={<OrderDetails />} />
        <Route path="/shipment" element={<ShipmentDetails />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;