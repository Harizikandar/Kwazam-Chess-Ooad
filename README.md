# Kwazam Chess - OOAD Project  

## Overview  
This project is developed as part of the **Object-Oriented Analysis and Design (OOAD)** course at Multimedia University. Kwazam Chess is a GUI-based Java application featuring a unique 5x8 chess game with custom rules and mechanics. The project emphasizes good object-oriented design principles and the use of the MVC pattern to separate logic from the GUI.

---

## Game Description  
Kwazam Chess is a two-player strategy game played on a 5x8 board. The initial game layout and piece movements are as follows:

### Pieces and Movements:
- **Ram**: Moves one step forward. If it reaches the end of the board, it turns around and moves in the opposite direction.
- **Biz**: Moves in an L-shape (3x2), similar to a knight in standard chess, and can skip over other pieces.
- **Tor**: Moves any distance orthogonally but cannot skip over other pieces. Transforms into an **Xor** after two turns.
- **Xor**: Moves any distance diagonally but cannot skip over other pieces. Transforms back into a **Tor** after two turns.
- **Sau**: Moves one step in any direction. The game ends when the **Sau** of either side is captured.

### Special Rules:
- Only the **Biz** can skip over other pieces.
- Tor and Xor alternate every two turns, introducing dynamic gameplay.

---

## Features  
- **GUI Application**: A user-friendly interface with resizable windows and menu options.  
- **Save & Load**: Save the game to a human-readable text file and load it back later.  
- **Screen Flipping**: The board flips for each player's turn.  
- **Dynamic Gameplay**: Unique mechanics like piece transformation after two turns.  
- **MVC Architecture**: Clear separation of model, view, and controller for flexible and maintainable code.

---

## Design Principles  
- **Object-Oriented Concepts**:  
  - Subclassing, delegation, composition, and aggregation.  
  - Polymorphism and encapsulation.  

- **Design Patterns**:  
  - **Model-View-Controller (MVC)**: Ensures the game logic and GUI remain separate.  
  - Singleton, Template Method, and at least one additional design pattern.  

- **Code Quality**:  
  - Proper indentation and naming conventions.  
  - Comprehensive class and method documentation.

---

## Deliverables  
1. **Java Source Code**:  
   - Well-commented classes and methods.  
   - Properly formatted and indented code.  

2. **Documentation**:  
   - Compile and run instructions for command-line execution.  
   - UML diagrams for class structure, use cases, and sequence flows.  
   - A detailed user manual.  

3. **Game Report**:  
   - Explanation of design decisions and patterns used.  
   - Gameplay rules and instructions.

---

## Contributors
- **Team Leader**: ALSAMMAN, LEEN
- **Team Members**:
  - LEEN AWAD MOHAMMED KHAIR HUSSEIN
  - HARITH ISKANDAR BIN MAT RADZUAN
  - YOGAMITTRAN A/L SHANMUGAM

---

## Acknowledgement
This project was developed as part of the OOAD course. Special thanks to the lecturer for guidance and support throughout the project.
