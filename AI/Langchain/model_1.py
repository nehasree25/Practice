#Chat model using Groq API

from langchain_groq import ChatGroq
from dotenv import load_dotenv

load_dotenv()

llm = ChatGroq(model='llama-3.1-8b-instant', temperature=0.7, max_tokens=100)
#temperature: Controls the randomness of the output. Higher values (e.g., 0.8) make the output more random, while lower values (e.g., 0.2) make it more focused and deterministic.
#model: Specifies the model to be used for generating responses. In this case, it's set to 'llama-3.1-8b-instant', which is a specific version of the LLaMA model.
#ChatGroq: This is a class provided by the langchain_groq library that allows you to interact with the Groq API for chat-based language models.
result = llm.invoke("What is the capital of India")
#invoke: This method is used to send a prompt or input to the language model and receive a generated response. In this case, the prompt is "What is the capital of India".
print(result.content)