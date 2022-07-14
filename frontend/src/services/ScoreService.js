import axios from "axios";

const SCORE_REST_API_URL = "http://localhost:8080/api/v1/scores/";

class ScoreService {
  processTextAreaInput(textAreaInput) {
    const splitInputArray = textAreaInput.split("\n");

    const matchScoresArray = [];
    for (let i = 0; i < splitInputArray.length; i++) {
      let [team1, team2, score1, score2] = splitInputArray[i].split(" ");

      matchScoresArray.push({
        team1Name: team1,
        team2Name: team2,
        team1Score: score1,
        team2Score: score2,
      });
    }

    return matchScoresArray;
  }

  saveMatchScores(matchScores) {
    return axios.post(SCORE_REST_API_URL, matchScores);
  }
}

export default new ScoreService();
