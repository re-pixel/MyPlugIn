import sys

def calculate_word_lengths(text):
    words = text.split()
    return "\n".join(f"{word}: {len(word)} characters" for word in words)

if __name__ == "__main__":
    if len(sys.argv) > 1:
        print(calculate_word_lengths(sys.argv[1]))
