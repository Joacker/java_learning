import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080',
  auth: {
    username: 'jfernandez',
    password: '2424'
  }
});

export default axiosInstance;