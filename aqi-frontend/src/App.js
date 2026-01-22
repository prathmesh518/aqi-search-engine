import { useState } from "react";
import "./App.css";

function getAqiCategory(aqi) {
  if (aqi <= 50) return { text: "Good", color: "good" };
  if (aqi <= 100) return { text: "Moderate", color: "moderate" };
  if (aqi <= 150) return { text: "Unhealthy for Sensitive", color: "sensitive" };
  if (aqi <= 200) return { text: "Unhealthy", color: "unhealthy" };
  if (aqi <= 300) return { text: "Very Unhealthy", color: "very" };
  return { text: "Hazardous", color: "hazardous" };
}

function App() {
  const [city, setCity] = useState("");
  const [data, setData] = useState(null);
  const [error, setError] = useState("");

  const searchCity = async () => {
    setError("");
    setData(null);

    if (!city.trim()) {
      setError("Please enter a city name");
      return;
    }

    try {
      const res = await fetch(
        `http://localhost:8080/api/aqi/search?city=${city}`
      );

      const result = await res.json();

      // AQICN search API gives list in result.data
      if (result.status !== "ok" || !result.data || result.data.length === 0) {
        setError("City not found!");
        return;
      }

      setData(result.data[0]); // showing first matched city
    } catch (err) {
      setError("Backend not running or network issue!");
    }
  };

  return (
    <div className="container">
      <h1>🌍 AQI Search Engine</h1>

      <div className="search-box">
        <input
          type="text"
          placeholder="Enter city name..."
          value={city}
          onChange={(e) => setCity(e.target.value)}
        />
        <button onClick={searchCity}>Search</button>
      </div>

      {error && <p className="error">{error}</p>}

      {data && (
        <div className="card">
          <h2>{data.station.name}</h2>
          <p>
            <b>City:</b> {data.station.name}
          </p>
          <p>
            <b>Country:</b> {data.station.country}
          </p>

          <p>
            <b>AQI:</b> <span className="aqi">{data.aqi}</span>
          </p>

          <p>
            <b>Category:</b>{" "}
            <span className={`badge ${getAqiCategory(data.aqi).color}`}>
              {getAqiCategory(data.aqi).text}
            </span>
          </p>

         
        </div>
      )}
    </div>
  );
}

export default App;

