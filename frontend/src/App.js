import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import TeamComponent from "./components/Team/TeamComponent";
import ScoreComponent from "./components/Score/ScoreComponent";
import ResultComponent from "./components/Result/ResultComponent";

function App() {
  return (
    <BrowserRouter>
      <div>
        <div className="container">
          <Routes>
            <Route exact path="/" element={<TeamComponent />} />
            <Route path="teams" element={<TeamComponent />} />
            <Route path="scores" element={<ScoreComponent />} />
            <Route path="results" element={<ResultComponent />} />
          </Routes>
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;
