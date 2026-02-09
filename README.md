# 📈 Financial Investment Portfolio Manager

This is a Java-based backend engine designed to manage and calculate the value of different financial assets using Object-Oriented Programming (OOP) principles.

## 🚀 Key Features
* **Polymorphism & Inheritance:** Implements a robust class hierarchy with an abstract base for different asset types.
* **Automated Calculations:** Handles dividend logic for Stocks and volatility factors for Cryptocurrencies.
* **Scalable Design:** Built to easily integrate new asset types (Real Estate, Gold, etc.) without modifying core logic.

## 🛠️ Technologies Used
* **Language:** Java (JDK 17+)
* **Concepts:** Abstract Classes, Encapsulation, Polymorphism, ArrayLists.

## 📋 How It Works
The system processes a list of `Activo` objects. Each subclass implements its own `calcularValorFinal()` method:
1. **Accion (Stocks):** Adds fixed dividends to the initial value.
2. **Cripto (Crypto):** Multiplies the value by a volatility index.

## 🏗️ Future Roadmap
- [ ] Integration with External API for real-time prices.
- [ ] CSV/JSON file import/export functionality.
- [ ] Graphical User Interface (GUI) or Web Dashboard.

## 🆙 Updates
* **Search engine** Implements a binary search engine with `RandomAccessFile` and a manual pointer managment.
* **Update prices** Implements a extra on the binary search engine for update the price when find the introduced name.
---
*Created as part of my "1 Million Goal" Dev Challenge.*
