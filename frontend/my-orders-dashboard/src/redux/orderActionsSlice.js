import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { fetchTrackingData } from '../utils/api';

// Thunk for tracking info
export const fetchTrackingThunk = createAsyncThunk(
  'orderActions/fetchTracking',
  async (orderId) => {
    const data = await fetchTrackingData(orderId);
    return data;
  }
);

const orderActionsSlice = createSlice({
  name: 'orderActions',
  initialState: {
    orderData: {
      id: '',
      status: '',
      total: '',
      date: '',
    },
    modal: {
      visible: false,
      title: '',
      message: '',
    },
    tracking: {
      loading: false,
      shipment: null,
      error: null,
    },
  },
  reducers: {
    setOrderData: (state, action) => {
      state.orderData = action.payload;
    },
    showModal: (state, action) => {
      state.modal = {
        visible: true,
        title: action.payload.title,
        message: action.payload.message,
      };
    },
    closeModal: (state) => {
      state.modal = {
        visible: false,
        title: '',
        message: '',
      };
    },
  },
  extraReducers: (builder) => {
    builder
      .addCase(fetchTrackingThunk.pending, (state) => {
        state.tracking.loading = true;
        state.tracking.error = null;
      })
      .addCase(fetchTrackingThunk.fulfilled, (state, action) => {
        state.tracking.shipment = action.payload.Shipment;
        state.tracking.loading = false;
      })
      .addCase(fetchTrackingThunk.rejected, (state) => {
        state.tracking.loading = false;
        state.tracking.error = 'Failed to fetch tracking info.';
      });
  },
});

// ✅ Export actions
export const { setOrderData, showModal, closeModal } = orderActionsSlice.actions;

// ✅ Export reducer as default
export default orderActionsSlice.reducer;
