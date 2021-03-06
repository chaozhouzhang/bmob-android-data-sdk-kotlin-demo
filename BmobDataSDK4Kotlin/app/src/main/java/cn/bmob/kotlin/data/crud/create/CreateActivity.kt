package cn.bmob.kotlin.data.crud.create

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import cn.bmob.kotlin.data.R
import cn.bmob.kotlin.data.base.BaseActivity
import cn.bmob.kotlin.data.bean.GameScore
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.SaveListener
import kotlinx.android.synthetic.main.activity_create.*


/**
 * 新增数据
 *  * Created on 2018/10/22 14:18
 * @author zhangchaozhou
 */
class CreateActivity : BaseActivity(), View.OnClickListener {



    override fun onClick(v: View?) {
        var id = v!!.id
        when (id) {
            R.id.btn_create_one -> createOne()
        }
    }




    /**
     * 新增一条数据
     */
    private fun createOne() {
        var gameScore = GameScore()
        gameScore.playerName = "比目"
        gameScore.score = 89
        gameScore.isPay = false
        /**
         * 请不要给 gameScore.objectId 赋值，数据新增成功后将会自动给此条数据的objectId赋值并返回！
         */
        gameScore.save(object : SaveListener<String>() {
            override fun done(objectId: String?, ex: BmobException?) {
                if (ex == null) {
                    Toast.makeText(mContext, "新增数据成功：$objectId", Toast.LENGTH_LONG).show()
                } else {
                    Log.e("CREATE", "新增数据失败：" + ex.message)
                }
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        btn_create_one.setOnClickListener(this)
    }
}