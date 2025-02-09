import axios from "axios";

const BASE_URL = "/api/v1/posts";

export const fetchPostsByUser = async (userId) =>
  axios.get(`${BASE_URL}/${userId}`);
export const savePost = async (post) => axios.post(`${BASE_URL}/`, post);
export const editPost = async (post) => axios.post(`${BASE_URL}/edit`, post);
