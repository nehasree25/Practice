from langchain_groq import ChatGroq
from dotenv import load_dotenv
from langchain_core.prompts import PromptTemplate

load_dotenv()

llm = ChatGroq(model='llama-3.1-8b-instant', temperature=0.7, max_tokens=100)
topic = input("Enter the topic: ")
template = PromptTemplate(
    template = "Generate a breif summary on {topic}",
    input_variables=['topic'],
    validate_template = True
)
prompt = template.invoke({'topic':topic})
result = llm.invoke(prompt)
print(result.content)