# Thermal Printer Formatter (58mm)

A simple Java utility designed to format long text files for printing on standard **58mm thermal receipt printers**.

Thermal printers often act as continuous streams and do not handle long texts or pagination natively. This tool takes a plain text file, wraps the text to fit the paper width, and splits it into "pages" with headers, footers, and cut lines.

## 🚀 Features

* **58mm Optimization:** Automatically wraps text to **32 characters** per line to fit standard narrow receipt paper.
* **Auto-Pagination:** Splits long text into pages (approx. 32 lines per page).
* **Headers & Footers:** Adds a header with the page number and a footer to mark the end of a segment.
* **Cut Lines:** Inserts `--- TEAR HERE ---` markers between pages for easy physical separation.
* **Safe Saving:** Generates new output files (`formatted_receipt1.txt`, `formatted_receipt2.txt`, etc.) instead of overwriting old ones.

## 🛠️ Installation & Setup

You only need the Java Runtime Environment (JRE) or Java Development Kit (JDK) installed.

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/sdmnc/termalprinterformater.git
    cd termalprinterformater
    ```

2.  **Compile the code** (from the repository root):
    ```bash
    javac -d out src/main/java/PrinterHelper.java
    ```

## 📖 Usage

1.  Put the text you want to print into **`print_me.txt`** in the repository root (a sample file is included).
2.  Run the program from the repository root:
    ```bash
    java -cp out PrinterHelper
    ```
3.  The program will generate a new file named **`formatted_receiptX.txt`** (where X is a number).
4.  Open the generated file and send it to your thermal printer.

`formatted_receipt1.txt` in this repository is the output for the sample `print_me.txt`.

## ⚙️ Configuration

Currently, the settings are hardcoded for standard 58mm paper:
* **Width:** 32 characters
* **Page Height:** 32 lines
* **Header:** "MY NOTES"

To change these settings, modify the variables in `PrinterHelper.java` and recompile.

## 📄 Example Output

If you input a long text, the output file will look like this:

```text
================================
MY NOTES [Pg 1]
================================
This is an example of how the te
xt will be wrapped if it exceeds
 the 32 character limit set for 
the printer.
...
================================
      END OF PAGE 1

--- TEAR HERE ---

================================
MY NOTES [Pg 2]
================================
...
```
