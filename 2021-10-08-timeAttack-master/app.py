from flask import Flask, render_template, jsonify, request
from pymongo import MongoClient
from datetime import datetime

app = Flask(__name__)

client = MongoClient("mongodb://localhost:27017/")
db = client.dbStock
idx_count = 0;


@app.route('/')
def index():
    return render_template('index.html')


@app.route('/post/save', methods=['POST'])
def save_post():
    global idx_count
    title_receive = request.form['title']
    content_receive = request.form['content']
    idx_count += 1
    index_receive = idx_count
    now_time = datetime.now()


    doc = {
        'title' : title_receive,
        'content' : content_receive,
        'reg_date' : now_time,
        'idx' : index_receive,
        'view': 0
    }
    db.memo.insert_one(doc)

    return {"result": "저장 완료!"}


@app.route('/post/print', methods=['GET'])
def get_post():
    memos = list(db.memo.find({},{'_id': False}).sort("reg_date", -1))
    return jsonify(memos)


@app.route('/post/delete', methods=['DELETE'])
def delete_post():
    idx_receive = request.form['idx']
    db.memo.delete_one({'idx': int(idx_receive)})
    return {"result": "삭제 완료!"}


@app.route('/post/add-view', methods=['POST'])
def update_view():
    idx_receive = request.form['idx']
    view_receive = request.form['view']
    current_view = int(view_receive) + 1

    db.memo.update_one({'idx': int(idx_receive)}, {'$set': {'view': current_view}})

    return {"result": "완료!"}


@app.route('/post/sort-view', methods=['GET'])
def sort_view():
    memos = list(db.memo.find({}, {'_id': False}).sort("view", -1))
    return jsonify(memos)


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)