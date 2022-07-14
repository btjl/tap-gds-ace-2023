import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import TeamComponent from "./components/Team/TeamComponent";

function App() {
  return (
    <BrowserRouter>
      <div>
        <div className="container">
          <Routes>
            <Route exact path="/" element={<TeamComponent />} />
            <Route path="teams" element={<TeamComponent />} />
          </Routes>
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;
