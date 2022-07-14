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
}

export default new TeamService();
