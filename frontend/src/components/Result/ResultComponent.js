import { React, useEffect, useState } from "react";
import ResultService from "../../services/ResultService";
import CompositeService from "../../services/CompositeService";
import TableRankingComponent from "./TableRankingComponent";
import { Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

const ResultComponent = () => {
  const [resultObj, setResultObj] = useState({});
  const navigate = useNavigate();

  const clearData = (e) => {
    e.preventDefault();

    CompositeService.clearData()
      .then((response) => {
        navigate("/");
      })
      .catch((error) => {
        console.log(error);
      });
  };

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

      <Button
        variant="btn btn-danger"
        type="submit"
        onClick={(e) => clearData(e)}
      >
        START OVER - CLEAR ALL DATA
      </Button>
    </div>
  );
};

export default ResultComponent;
