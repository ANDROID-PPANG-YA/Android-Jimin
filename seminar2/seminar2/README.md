# 🌱Seminar 2
## 1️⃣ Level 1 실행화면
<img src="https://user-images.githubusercontent.com/92876819/164729685-90c1f660-099e-49ca-b70c-64cd04fe523c.gif" width="200" height="400"/>

## 2️⃣ 코드 설명
### **1. Fragment 만들기**
  - 이번 과제에서는 repository_fragment, follower_fragment 필요
 
#### fragment_follower.xml
```kotlin
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    tools:context=".FollowerFragment">

    <androidx.recyclerview.widget.RecyclerView #리사이클러뷰 레이아웃 
        android:id="@+id/rv_Follower"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager" #LayoutManager 클래스를 불러 원하는 형태 선택(팔로워는 선형으로 선택)
        tools:itemCount="6" #보여줄 데이터 개수 
        tools:listitem="@layout/follower_list" /> #팔로워 리스트 레이아웃 사용

```
#### FollowerFragment.kt
```kotlin
class FollowerFragment : Fragment() {

    private lateinit var followerAdapter: FollowerAdapter
    private var _binding : FragmentFollowerBinding? = null #nullable한 변수로 선언(메모리 누수 방지)
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)

        initFollowerAdaptor()
        return binding.root
    }
        // Inflate the layout for this fragment
    private  fun initFollowerAdaptor(){
            followerAdapter = FollowerAdapter()
            binding.rvFollower.adapter= followerAdapter

#만든 팔로워 데이터 클래스 형식에 원하는 데이터를 입력
            followerAdapter.followerList.addAll(
                listOf(
                    FollowerData("양지영", "7조"),
                    FollowerData("이혜빈", "7조"),
                    FollowerData("유지민", "7조"),
                    FollowerData("정지연", "7조"),
                    FollowerData("조재훈", "7조")
                )
            )
            followerAdapter.notifyDataSetChanged()
    }

#메모리 누수 방지를 위해 binding 객체 참조 해제
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
}
```
 

- #### follower_list.xml
  - 데이터를 어떻게 담을지 레이아웃 설정해주기
  - 재사용되는 레이아웃

- #### FollowerData.kt
- 팔로워와 관련된 어떤 정보를 공통적으로 담을지 적어놓은 클래스
```kotlin
data class FollowerData(
    val name : String,
    val introduce : String
)
```
#### FollowerAdapter.kt
  - Adapter와 ViewHolder를 담고 있음
  - Adapter는 onCreateViewHolder, onBindViewHolder, getItemCount를 override 해주어야 한다.
  - nested 구조로 ViewHolder 클래스도 가지고 있다.

```kotlin
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding =
            FollowerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) { #ViewHolder가 가진 뷰에 Adapter로부터 전달받은 데이터 전달
        holder.onBind(followerList[position])
    }

    override fun getItemCount(): Int = followerList.size

``` 

```kotlin
class FollowerViewHolder(
        private val binding : FollowerListBinding
    ) : RecyclerView.ViewHolder(binding.root) { #재활용할 레이아웃의 루트뷰를 넘겨준다.
        fun onBind(data : FollowerData) {
            binding.tvName.text = data.name
            binding.tvIntroduction.text = data.introduce
        }
```


#### HomeActivity.kt
  - 처음에 등장하는 뷰가 팔로워수이도록 fragment1을 FollowerFragment()로 설정  

```kotlin
private fun initTransactionEvent() {
        val fragment1 = FollowerFragment()
        val fragment2 = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.fragment_home, fragment1).commit()

        binding.btnFollower.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            when(position) {
                FIRST_POSITION -> {
                    transaction.replace(R.id.fragment_home, fragment1)
                    position = SECOND_POSITION
                }
            }
            transaction.commit()
            }

        binding.btnRepository.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            when(position) {
                SECOND_POSITION -> {
                    transaction.replace(R.id.fragment_home,fragment2)
                    position = FIRST_POSITION
                }
            }
            transaction.commit()
        }

            }

    companion object {
        const val FIRST_POSITION = 1
        const val SECOND_POSITION = 2
    }
```

## 3️⃣ 과제를 통해 배운 내용
  💡 ViewHolder를 활용해 편리하게 반복되는 레이아웃을 재사용하기<br>
  💡 여러 개의 fragment 전환하기<br>
  💡 Fragment View의 생명주기가 Fragmnet의 생명주기보다 짧기 때문에 발생할 수 있는 메모리 누수 방지하는 방법(binding 활용) 
