import React from "react";
import { Form, Button } from "react-bootstrap";

const TeamComponent = () => {
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

export default TeamComponent;
