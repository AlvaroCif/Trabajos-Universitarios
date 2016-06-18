from flask import Flask
app = Flask(__name__)


from sklearn.externals import joblib

  
regr = joblib.load('filename.pkl') 


@app.route("/")
def hello():
    return "Hello World!"
	
@app.route("/predict/<int:op1>/<int:op>/<int:op2>/<int:mayor>")
def predict(op1,op2,op,mayor):
	arr = [op1, op, op2, mayor]
	return str(regr.predict(arr))

if __name__ == "__main__":
    app.run()


