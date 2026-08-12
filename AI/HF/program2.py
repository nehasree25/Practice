from transformers import pipeline

classifier = pipeline("image-classification")
classification = classifier("image.png")
print(classification)