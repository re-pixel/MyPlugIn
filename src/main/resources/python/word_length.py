def calculate_word_lengths(text):
    """
    Calculate and return word lengths from the given text.

    Args:
        text (str): The input text to analyze.

    Returns:
        str: Formatted string of word lengths.
    """
    words = text.split()
    return "\n".join(f"{word}: {len(word)} characters" for word in words)

if __name__ == "__main__":
    # For direct script execution
    import sys
    if len(sys.argv) > 1:
        print(calculate_word_lengths(sys.argv[1]))