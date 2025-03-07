const express = require('express');
const app = express();
const PORT = 3000;

const generarNumerosAleatorios = () => {
    return Array.from({ length: 10 }, () => Math.floor(Math.random() * 100) + 1);
};

app.get('/numeros', (req, res) => {
    res.json({ numeros: generarNumerosAleatorios() });
});

app.listen(PORT, () => {
    console.log(`Servidor corriendo en http://localhost:${PORT}`);
});