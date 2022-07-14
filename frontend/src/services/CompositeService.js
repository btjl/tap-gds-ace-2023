import axios from "axios";

const COMPOSITE_REST_API_URL = "http://localhost:8080/api/v1/composite/";

class CompositeService {
  clearData() {
    return axios.delete(COMPOSITE_REST_API_URL + "clear");
  }
}

export default new CompositeService();
