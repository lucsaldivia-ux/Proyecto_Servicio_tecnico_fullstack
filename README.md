# 🛠️ Sistema de Gestión de Servicio Técnico (Full Stack)

![Licencia](https://img.shields.io/badge/licencia-MIT-blue.svg)
![Estado](https://img.shields.io/badge/estado-En_Desarrollo-green)

Plataforma web Full Stack orientada a optimizar la administración y flujo de trabajo de un taller o centro de servicio técnico. Permite registrar clientes, gestionar órdenes de trabajo/reparación, dar seguimiento al estado de los equipos y mantener el historial centralizado.

---

## 🚀 Características Principales

- **Gestión de Clientes:** Registro, actualización y consulta de historial de clientes.
- **Órdenes de Servicio:** Recepción de equipos, diagnóstico inicial, asignación de técnicos y presupuestos.
- **Seguimiento en Tiempo Real:** Control de estados de reparación (*Ingresado*, *En Diagnóstico*, *En Espera de Repuesto*, *Reparado*, *Entregado*).
- **Módulo de Autenticación:** Control de acceso seguro para administradores y técnicos mediante roles.
- **Reportes / Historial:** Registro detallado de intervenciones y piezas sustituidas.

---

## 🛠️ Tecnologías Utilizadas

### Frontend
- **Framework / Librería:** [ej. React / Vue / Next.js]
- **Estilos:** [ej. Tailwind CSS / Bootstrap / CSS Modules]
- **Gestión de Estado / Cliente HTTP:** [ej. Axios / Redux / Context API]

### Backend
- **Entorno de Ejecución:** [ej. Node.js / Python / Java / PHP]
- **Framework:** [ej. Express / Django / Spring Boot / Laravel]
- **Autenticación:** [ej. JWT / OAuth]

### Base de Datos & Despliegue
- **Base de Datos:** [ej. PostgreSQL / MySQL / MongoDB]
- **ORM / Query Builder:** [ej. Prisma / Sequelize / TypeORM]
- **Despliegue:** [ej. Vercel / Render / Railway / Docker]

---

## 📁 Estructura del Proyecto

```text
├── client/              # Código del Frontend (Interfaz de Usuario)
├── server/              # Código del Backend (API RESTful)
│   ├── controllers/     # Lógica de negocio
│   ├── models/          # Modelos de base de datos
│   ├── routes/          # Endpoints de la API
│   └── middlewares/     # Autenticación y validaciones
└── README.md
