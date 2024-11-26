FROM python:3-alpine3.15
WORKDIR /app
COPY . /app
RUN pip3 install flask
EXPOSE 5000
CMD ["python3","app.py"]