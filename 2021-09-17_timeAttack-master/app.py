from flask import Flask, render_template, jsonify, request
app = Flask(__name__)

from pymongo import MongoClient
client = MongoClient('localhost', 27017)
db = client.dbStock

@app.route('/')
def home():
    return render_template('index.html')


@app.route('/codess', methods=['POST'])
def write_review():
    sample_receive = request.form['sample_give']
    print(sample_receive)
    return jsonify({'msg': '이 요청은 POST!'})


@app.route('/codes', methods=['GET'])
def read_reviews():
    group_list = list(db.codes.distinct("group"))
    first_group = list(db.codes.find({'group':group_list[1]}))
    print("test")
    return jsonify({'groups':group_list})


if __name__ == '__main__':
    app.run('0.0.0.0', port=5000, debug=True)