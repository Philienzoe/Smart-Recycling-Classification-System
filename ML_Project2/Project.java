/*
	Do not edit any given code in this file.
*/

import java.io.IOException;
import java.util.Scanner;

public class Project {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Model model = new Model();

		while (true) {
			System.out.println("=== Smart Recycling Classification System ===");
			System.out.println("1. Train a new model");
			System.out.println("2. Save the current model");
			System.out.println("3. Load a model");
			System.out.println("4. Classify an image");
			System.out.println("5. Quit");
			System.out.print("Please select an option: ");

			String input = sc.nextLine().trim();

			switch (input) {
				case "1":
					try {
						System.out.print("Enter the path of the training dataset: ");
						String trainPath = sc.nextLine().trim();
						System.out.print("Enter the number of labels: ");
						int numLabel = Integer.parseInt(sc.nextLine().trim());
						System.out.print("Enter the number of training iterations: ");
						int iter = Integer.parseInt(sc.nextLine().trim());
						System.out.print("Enter the learning rate: ");
						double lr = Double.parseDouble(sc.nextLine().trim());
						model.trainModel(numLabel, iter, trainPath, lr);
						System.out.println("Model trained successfully.");
					} catch (IOException e) {
						System.out.println("Error during training: " + e.getMessage());
					} catch (NumberFormatException e) {
						System.out.println("Invalid input. Please enter a valid number.");
					}
					break;

				case "2":
					try {
						System.out.print("Enter the path to save the model: ");
						String savePath = sc.nextLine().trim();
						model.save(savePath);
						System.out.println("Model saved successfully.");
					} catch (IOException e) {
						System.out.println("Error saving model: " + e.getMessage());
					}
					break;

				case "3":
					try {
						System.out.print("Enter the path of the model file to load: ");
						String loadPath = sc.nextLine().trim();
						model.load(loadPath);
						System.out.println("Model loaded successfully.");
					} catch (IOException e) {
						System.out.println("Error loading model: " + e.getMessage());
					}
					break;

				case "4":
					try {
						System.out.print("Enter the path of the image to classify: ");
						String imagePath = sc.nextLine().trim();
						int result = model.classification(imagePath);
						if (result == 0) {
							System.out.println("Classification result: Can (label 0)");
						} else if (result == 1) {
							System.out.println("Classification result: Bottle (label 1)");
						} else {
							System.out.println("Classification result: label " + result);
						}
					} catch (IOException e) {
						System.out.println("Error during classification: " + e.getMessage());
					}
					break;

				case "5":
					System.out.println("Goodbye!");
					sc.close();
					return;

				default:
					System.out.println("Invalid option. Please select 1-5.");
					break;
			}
			System.out.println();
		}
	}
}
