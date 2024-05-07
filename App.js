import React, { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [kogus, setKogus] = useState(0);
  const [matkajad, setMatkajad] = useState([]);
  const nimiRef = useRef();
  const kilomeetridRef = useRef();
  const riigidRef = useRef();

  //useEffect(() => {
    //fetch("http://localhost:8080/matkajad")
      //.then(response => response.json())
      //.then(json => {
        //setMatkajad(json);
        //setKogus(json.length);
      //});
  //}, []);

  function kustuta(id) {
    fetch(`http://localhost:8080/matkajad/${id}`, { method: "DELETE" })
      .then(response => response.json())
      .then(json => {
        setMatkajad(json);
        setKogus(json.length);
      });
  }

  function lisaMatkaja() {
    const matkaja = {
      "nimi": nimiRef.current.value,
      "elusLabitudKilomeetrid": kilomeetridRef.current.value,
      "kylastatudRiikideArv": riigidRef.current.value
    };
    fetch("http://localhost:8080/matkajad", {
      method: "POST",
      body: JSON.stringify(matkaja),
      headers: { "Content-Type": "application/json" }
    })
      .then(response => response.json())
      .then(json => {
        setMatkajad(json);
        setKogus(json.length);
      });
  }

  return (
    <div className="App">
      <div>
        Matkajaid on {kogus}
        <br /><br />
        
        <label>Matkaja nimi</label> <br/>
        <input ref={nimiRef} type="text" /> <br />
        <label>Elus läbitud kilomeetrid</label> <br/>
        <input ref={kilomeetridRef} type="text" /> <br />
        <label>Külastatud riikide arv</label> <br/>
        <input ref={riigidRef} type="text" /> <br />
        <button onClick={() => lisaMatkaja()}>Lisa matkaja</button> <br />
        <br />

        {matkajad.map(m => (
          <div key={m.id}>
            {m.nimi} | {m.elusLabitudKilomeetrid} km | {m.kylastatudRiikideArv} riiki <button onClick={() => kustuta(m.id)}>x</button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
