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
}

export default new ScoreService();
