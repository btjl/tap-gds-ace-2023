import axios from "axios";

const RESULT_REST_API_URL = "http://localhost:8080/api/v1/results/";

class ResultService {
  getResults() {
    return axios.get(RESULT_REST_API_URL);
  }
}

export default new ResultService();
