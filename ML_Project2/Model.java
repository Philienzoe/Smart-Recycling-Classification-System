/*
	Do not edit any given code in this file.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Model {

    /**
     * The weight matrix between layer 3 and the output layer
     */
	private double[][] weights;
    
    /**
     * The bias vector of the output layer
     */
	private double[] bias;

	/**
	 * No-arg constructor with empty body
	 */
	public Model() {
	}

	/**
	 * Constructor that initializes the model to be a DEEP COPY of the given arguments
	 * @param weights a double[][] that keeps the data of weights
	 * @param bias a double[] that keeps the data of bias
	 */
	public Model(double[][] weights, double[] bias) {
		this.weights = new double[weights.length][];
		for (int i = 0; i < weights.length; i++) {
			this.weights[i] = new double[weights[i].length];
			for (int j = 0; j < weights[i].length; j++) {
				this.weights[i][j] = weights[i][j];
			}
		}
		this.bias = new double[bias.length];
		for (int i = 0; i < bias.length; i++) {
			this.bias[i] = bias[i];
		}
	}

	/**
	 * Constructor that initializes the model from a given saved model file
	 * @param path A String that indicates the path of the saved model file
	 */
	public Model(String path) {
		try {
			load(path);
		} catch (IOException e) {
			System.out.println("Error loading model: " + e.getMessage());
		}
	}

	/**
	 * The getter of the weights field.
	 */
	public double[][] getWeights() {
		return weights;
	}

	/**
	 * The getter of the bias field.
	 */
	public double[] getBias() {
		return bias;
	}

	
	/**
	 * Saves the current model (weights and bias) into a file
	 * @param path A String that indicates the path to the destination location for saving the file
	 */
	public void save(String path) throws IOException {
		FileWriter fw = new FileWriter(path);
		fw.write("weights\n");
		for (int i = 0; i < weights.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < weights[i].length; j++) {
				if (j > 0) {
					sb.append(",");
				}
				sb.append(weights[i][j]);
			}
			fw.write(sb.toString() + "\n");
		}
		fw.write("bias\n");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bias.length; i++) {
			if (i > 0) {
				sb.append(",");
			}
			sb.append(bias[i]);
		}
		fw.write(sb.toString() + "\n");
		fw.close();
	}

	/**
	 * Loads the model from a saved model file
	 * @param path A String that indicates the path to the model file to be loaded
	 */
	public void load(String path) throws IOException {
		Scanner sc = new Scanner(new File(path));
		ArrayList<double[]> weightRows = new ArrayList<>();

		// Read and skip the "weights" header line
		sc.nextLine();

		// Read weight rows until we hit the "bias" line
		String line = sc.nextLine();
		while (!line.equals("bias")) {
			String[] parts = line.split(",");
			double[] row = new double[parts.length];
			for (int i = 0; i < parts.length; i++) {
				row[i] = Double.parseDouble(parts[i]);
			}
			weightRows.add(row);
			line = sc.nextLine();
		}

		// Convert ArrayList to double[][]
		weights = new double[weightRows.size()][];
		for (int i = 0; i < weightRows.size(); i++) {
			weights[i] = weightRows.get(i);
		}

		// Read the bias line
		line = sc.nextLine();
		String[] biasParts = line.split(",");
		bias = new double[biasParts.length];
		for (int i = 0; i < biasParts.length; i++) {
			bias[i] = Double.parseDouble(biasParts[i]);
		}

		sc.close();
	}

	/**
	 * A method that trains the model
	 * @param 1: An int that indicates the number of possible output labels
	 * @param 2: An int that indicates the number of iteration for the training
	 * @param 3: A String the indicates the path of the directory that keeps the training data
	 * @param 4: A double that indicates the learning rate
	 */
	public void trainModel(int numLabel, int iter, String path, double learningRate) throws IOException {
		Model m = Trainer.train(numLabel, iter, path, learningRate);
		weights = m.getWeights();
		bias = m.getBias();
	}
	
	/**
	 * A method that performs classification according to the current model
	 * @param 1: A String that indicates the location of the target data that to be classified
	 * @return the integer that indicates the classification result (the label)
	 */
	public int classification(String file) throws IOException {
		return Trainer.predict(file, weights, bias);
	}
	
	/**
	 * Prints the weight matrix for debugging purpose if needed
	 */
	public void printWeights() {
		if (weights != null)
			ExtraMUtil.matPrint(weights);
	}
	
	/**
	 * Prints the bias vector for debugging purpose if needed
	 */
	public void printBias() {
		if (bias != null)
			ExtraMUtil.vecPrint(bias);
	}
}
