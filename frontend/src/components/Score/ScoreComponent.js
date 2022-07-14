import React from "react";
import { Form, Button } from "react-bootstrap";

const ScoreComponent = () => {
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
            />
          </Form.Group>
          <Button variant="primary" type="submit">
            Submit
          </Button>
        </Form>
      </div>
    </div>
  );
};

export default ScoreComponent;
