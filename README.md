# LZW Compression And Decompression Algorithm Implementation

Welcome to our LZW (Lempel-Ziv-Welch) compression algorithm implementation project.

## Project Overview
The project consists of the following Java classes:

- `LZW`: Contains methods for LZW encoding and decoding, along with functionalities for compressing and decompressing files using the LZW algorithm.
- `LZWFileHandler`: Handles file input and output operations for LZW-encoded data.
- `TextFileHandler`: Manages text data input and output operations.

## Usage

The `Main` class provides a simple command-line interface for the user to perform LZW compression and decompression operations on files. The menu-driven interface allows the user to:
- Compress a file
- Decompress a file
- Exit the program

## Program Structure
Our project is organized around a primary Java class, `LZWCompression`, which encompasses methods responsible for both compressing and decompressing data utilizing the LZW algorithm.

## Features
- Ability to compress text data using the LZW algorithm.
- Decompression of LZW-compressed data to retrieve the original text.

## File Handling

- The project handles input and output for files containing encoded data or plain text.
- File paths should be provided for input and destination files during compression and decompression operations.

## Error Handling

- The program handles common errors such as file not found or I/O exceptions during file operations.
- Error messages are displayed to inform users about encountered issues.


## Authors
- [Amr Khaled El-Hennawi](https://github.com/AmrElhennawi)
- [Yusuf Elsayed Badr](https://github.com/yusufbadr)

## License

This project is under an MIT License. Refer to the `LICENSE` file for more details.

##

Explore our code and start using the LZW compression algorithm for your data compression needs!

**Note:** This implementation is for educational purposes and may not be as optimized or feature-rich as dedicated compression libraries or utilities.
