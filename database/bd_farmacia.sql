-- ==========================================================
-- Base de datos: bd_farmacia
-- Proyecto: Sistema de Gestion de Medicamentos para Farmacia
-- Uso:
--   1. Abrir MySQL Workbench.
--   2. Pegar o abrir este archivo SQL.
--   3. Ejecutar el script antes de iniciar Spring Boot.
-- ==========================================================

CREATE DATABASE IF NOT EXISTS bd_farmacia;

USE bd_farmacia;

CREATE TABLE IF NOT EXISTS medicamentos (
    id_medicamento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    laboratorio VARCHAR(100) NOT NULL,
    categoria VARCHAR(80) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    fecha_vencimiento DATE NOT NULL,
    estado VARCHAR(20) NOT NULL
);

-- Datos de prueba para practicar listar, buscar, editar y eliminar.
-- Ejecutar esta seccion una sola vez para evitar registros duplicados.
INSERT INTO medicamentos
(nombre, laboratorio, categoria, precio, stock, fecha_vencimiento, estado)
VALUES
('Paracetamol 500mg', 'Genfar', 'Analgesico', 3.50, 100, '2027-05-10', 'Disponible'),
('Ibuprofeno 400mg', 'MK', 'Antiinflamatorio', 5.20, 80, '2026-12-15', 'Disponible'),
('Amoxicilina 500mg', 'Bayer', 'Antibiotico', 12.90, 40, '2026-08-20', 'Disponible'),
('Loratadina 10mg', 'Portugal', 'Antialergico', 2.80, 120, '2027-01-30', 'Disponible'),
('Omeprazol 20mg', 'AC Farma', 'Gastrointestinal', 4.60, 60, '2026-10-05', 'Disponible');

SELECT * FROM medicamentos;
