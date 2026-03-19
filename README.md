# Smart Recycling Classification System

A Java-based AI application that classifies images of **plastic bottles** and **aluminum cans** using machine learning. Built as an individual project for IS5311 Java Programming for Business Applications at City University of Hong Kong.

## Overview

This application trains a simple neural network model on labeled image data and uses it to classify whether a given image contains a plastic bottle or an aluminum can. The ML components (forward pass, backpropagation, training loop) are provided as pre-compiled black-box classes. The project focuses on:

- Implementing matrix operations from scratch (addition, multiplication, transpose, etc.)
- Building a Model class with file-based persistence (save/load)
- Designing a menu-driven console application flow

## Project Structure

```
ML_Project2/
├── Data/
│   ├── train/
│   │   ├── 0/          # Can images (label 0)
│   │   └── 1/          # Bottle images (label 1)
│   └── test/
│       ├── 0/          # Test can images
│       └── 1/          # Test bottle images
├── ExtraMUtil.java     # Matrix operation utilities
├── Model.java          # AI model class (train, save, load, classify)
├── Project.java        # Main application with menu interface
├── Trainer.class       # ML training engine (black box)
├── Layer1.class        # Neural network layer 1 (black box)
├── Layer2.class        # Neural network layer 2 (black box)
├── Layer3.class        # Neural network layer 3 (black box)
└── MUtil.class         # ML math utilities (black box)
```

## Features

- **Train a model** — Feed labeled training images to build a classification model
- **Save/Load model** — Persist trained model weights and bias to a file for reuse
- **Classify images** — Predict whether a new image is a bottle or a can
- **Matrix operations** — Custom implementations of matrix addition, multiplication, transpose, element-wise product, sub-matrix extraction, flatten, and reshape

## Matrix Operations Implemented

| Method | Description |
|--------|-------------|
| `matAddition` | Element-wise addition of two matrices |
| `matProduct` | Standard matrix multiplication |
| `matElemProduct` | Element-wise (Hadamard) multiplication |
| `matSum` | Sum of all elements in a matrix |
| `matTranspose` | Transpose a matrix (swap rows and columns) |
| `subMat` | Extract a sub-matrix by row/column range |
| `matToVec` | Flatten a 3D matrix into a 1D vector |
| `vecToMat` | Reshape a 1D vector into a 3D matrix |

## Getting Started

### Prerequisites

- Java SE 8 or above

### Compile and Run

```bash
javac Project.java
java Project
```

### Usage

The application presents a menu with 5 options:

```
=== Smart Recycling Classification System ===
1. Train a new model
2. Save the current model
3. Load a model
4. Classify an image
5. Quit
```

### Example Workflow

**1. Train a model**
```
Option: 1
Path: Data/train
Labels: 2
Iterations: 100
Learning rate: 0.01
```

**2. Save the trained model**
```
Option: 2
Path: model.txt
```

**3. Load a saved model**
```
Option: 3
Path: model.txt
```

**4. Classify a test image**
```
Option: 4
Path: Data/test/0/0218084110.jpg
→ Classification result: Can (label 0)
```

## Model File Format

The saved model file follows this structure:

```
weights
0.123,0.456,0.789
0.321,0.654,0.987
bias
0.111,0.222
```

## Tech Stack

- **Language:** Java
- **Data structures:** Arrays, ArrayList, 2D/3D arrays
- **I/O:** Scanner, FileWriter, File
- **Concepts:** OOP (encapsulation, constructor overloading, deep copy), matrix math, file persistence

## License

This project was developed for academic purposes as part of IS5311 at CityU HK.
