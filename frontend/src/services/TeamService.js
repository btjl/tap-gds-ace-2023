import axios from "axios";

const TEAM_REST_API_URL = "http://localhost:8080/api/v1/teams/";
class TeamService {
  processTextAreaInput(textAreaInput) {
    const splitInputArray = textAreaInput.split("\n");

    const teamsArray = [];
    for (let i = 0; i < splitInputArray.length; i++) {
      let [curName, curRegistrationDate, curGroup] =
        splitInputArray[i].split(" ");

      teamsArray.push({
        id: i,
        name: curName,
        registrationDate: curRegistrationDate,
        groupNumber: curGroup,
      });
    }

    return teamsArray;
  }

  registerTeams(teamsObj) {
    return axios.post(TEAM_REST_API_URL, teamsObj);
  }
}

export default new TeamService();
