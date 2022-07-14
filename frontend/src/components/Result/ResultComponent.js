import { React, useEffect, useState } from "react";
import ResultService from "../../services/ResultService";
import { Button } from "react-bootstrap";

const ResultComponent = () => {
  const [resultObj, setResultObj] = useState({});

  useEffect(() => {
    getAllResults();
  }, []);

  const getAllResults = () => {
    ResultService.getResults()
      .then((response) => {
        setResultObj(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="container">
      <h1>Rankings</h1>
      <h2>Group 1</h2>

      <h2>Group 2</h2>

      <Button variant="btn btn-danger" type="submit">
        START OVER - CLEAR ALL DATA
      </Button>
    </div>
  );
};

export default ResultComponent;
