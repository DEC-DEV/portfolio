package com.example.kosmobank;

public class ResultDTO {

    private int insertCnt;
    private int updateCnt;
    private int deleteCnt;

    // setters, getters
    public int getInsertCnt() {
        return insertCnt;
    }

    public void setInsertCnt(int insertCnt) {
        this.insertCnt = insertCnt;
    }

    public int getUpdateCnt() {
        return updateCnt;
    }

    public void setUpdateCnt(int updateCnt) {
        this.updateCnt = updateCnt;
    }

    public int getDeleteCnt() {
        return deleteCnt;
    }

    public void setDeleteCnt(int deleteCnt) {
        this.deleteCnt = deleteCnt;
    }

    // toString()
    @Override
    public String toString() {
        return "resultDTO{" +
                "insertCnt=" + insertCnt +
                ", updateCnt=" + updateCnt +
                ", deleteCnt=" + deleteCnt +
                '}';
    }
}
