import { React, useState } from "react";
import { Form, Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import ScoreService from "../../services/ScoreService";

const ScoreComponent = () => {
  const [textAreaInput, setTextAreaInput] = useState("");
  const navigate = useNavigate();

  const saveScoresInformation = (e) => {
    e.preventDefault();

    const matchScores = ScoreService.processTextAreaInput(textAreaInput);

    ScoreService.saveMatchScores(matchScores)
      .then((response) => {
        navigate("/results", response);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div>
      <h1>Score page</h1>
      <div className="container">
        <Form>
          <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
            <Form.Label>Scores Form</Form.Label>
            <Form.Control
              as="textarea"
              rows={12}
              placeholder="<Team A name> <Team B name> <Team A goals scored> <Team B goals scored>&#10;<Team B name> <Team C name> <Team B goals scored> <Team C goals scored>&#10;<Team C name> <Team D name> <Team C goals scored> <Team D goals scored>"
              onChange={(e) => setTextAreaInput(e.target.value)}
            />
          </Form.Group>
          <Button
            variant="primary"
            type="submit"
            onClick={(e) => saveScoresInformation(e)}
          >
            Submit
          </Button>
        </Form>
      </div>
    </div>
  );
};

export default ScoreComponent;
