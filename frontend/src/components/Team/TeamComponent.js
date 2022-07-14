import { React, useState } from "react";
import TeamService from "../../services/TeamService";
import { Form, Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

const TeamComponent = () => {
  const [textAreaInput, setTextAreaInput] = useState("");
  const navigate = useNavigate();

  const saveTeamsInformation = (e) => {
    e.preventDefault();

    const teamsInformationObject =
      TeamService.processTextAreaInput(textAreaInput);

    console.log(teamsInformationObject);

    TeamService.registerTeams(teamsInformationObject)
      .then((response) => {
        navigate("/scores");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div>
      <h1>Team Registration</h1>
      <div className="container">
        <Form>
          <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
            <Form.Label>Team Information Form</Form.Label>
            <Form.Control
              as="textarea"
              rows={12}
              placeholder="<Team A name> <Team A registration date in DD/MM> <Team A group number>&#10;<Team B name> <Team B registration date in DD/MM> <Team B group number>&#10;<Team C name> <Team C registration date in DD/MM> <Team C group number>&#10;..."
              onChange={(e) => setTextAreaInput(e.target.value)}
            />
          </Form.Group>
          <Button
            variant="primary"
            type="submit"
            onClick={(e) => saveTeamsInformation(e)}
          >
            Submit
          </Button>
        </Form>
      </div>
    </div>
  );
};

export default TeamComponent;
