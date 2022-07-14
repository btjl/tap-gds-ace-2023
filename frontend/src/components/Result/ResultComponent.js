import { React, useEffect, useState } from "react";
import ResultService from "../../services/ResultService";
import TableRankingComponent from "./TableRankingComponent";
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
      <TableRankingComponent data={resultObj["group1Rankings"]} />

      <h2>Group 2</h2>
      <TableRankingComponent data={resultObj["group2Rankings"]} />

      <Button variant="btn btn-danger" type="submit">
        START OVER - CLEAR ALL DATA
      </Button>
    </div>
  );
};

export default ResultComponent;
