from huggingface_hub import list_models

models = list_models(
    search="image",
    limit=5
)

for model in models:
    print(model.id)