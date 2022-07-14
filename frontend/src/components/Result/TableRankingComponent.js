import React from "react";
import Table from "react-bootstrap/Table";

const TableRankingComponent = (props) => {
  const teamRankings = props.data;

  return (
    <div>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>Team Name</th>
            <th>Total Match Point</th>
            <th>Total Goals</th>
            <th>Total Alternate Match Points</th>
            <th>Registration Date In Days - Smaller equals earlier</th>
            <th>Qualify for next round?</th>
          </tr>
        </thead>
        <tbody>
          {teamRankings &&
            teamRankings.map(
              (
                {
                  teamName,
                  totalMatchPoint,
                  totalGoals,
                  totalAlternateMatchPoint,
                  registrationDateInDays,
                },
                index
              ) => (
                <tr key={index}>
                  <td>{teamName}</td>
                  <td>{totalMatchPoint}</td>
                  <td>{totalGoals}</td>
                  <td>{totalAlternateMatchPoint}</td>
                  <td>{registrationDateInDays}</td>
                  <td>{index <= 3 ? "YES" : "NO"}</td>
                </tr>
              )
            )}
        </tbody>
      </Table>
    </div>
  );
};

export default TableRankingComponent;
