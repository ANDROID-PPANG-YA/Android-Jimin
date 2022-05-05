# 🌱Seminar 1

## 1️⃣ Level 1 실행화면

<img src="https://user-images.githubusercontent.com/92876819/162605596-47a039a7-f9e8-4ce7-b699-6d873e55b598.gif" width="200" height="400"/>

 

## 2️⃣ 코드 설명

- **SigininActivity.kt**

```kotlin

        val suIntent = Intent(this, SignUpActivity::class.java) //회원가입 페이지로 전환하기 위한 indent

        val homeIntent = Intent(this, HomeActivity::class.java) //로그인 성공 시 홈 페이지로 전환하기 위한 intent

 

        val etId = binding.editId.text //아이디 입력창에 입력된 텍스트 참조하기

        val etPw = binding.editPw.text //비번 입력창에 입력된 텍스트 참조하기

 

        //로그인 버튼 눌렀을 때 입력값이 없으면 메세지 띄우기, 아니라면 홈 페이지로 이동

        binding.buttonSi.setOnClickListener {

            if (etId.isEmpty() || etPw.isEmpty()) {

                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()

            }else{

                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

                startActivity(homeIntent)

            }

        }

        //회원가입 버튼 누르면 SignUp 페이지로 이동

        binding.buttonSu.setOnClickListener{

            startActivity(suIntent)

        }

```

 

-**SignUpActivity.kt**

```kotlin

        //회원가입 성공하면 로그인 페이지로 다시 이동할 수 있도록

        val siIntent = Intent(this, SignInActivity::class.java)

        

        //텍스트 입력값 참조용

        val eName = binding.EditName.text

        val eId = binding.EditId.text

        val ePw = binding.EditPw.text

 

        //회원가입 버튼 눌렀을 때 입력값 없으면 메세지 띄우기, 가입 성공 시 로그인 페이지로 이동

        binding.buttonSuCom.setOnClickListener {

            if (eName.isEmpty() || eId.isEmpty() || ePw.isEmpty()) {

                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()

            }else{

                startActivity(siIntent)

                finish()}

        }

    }

```

 

-**activity_sign_in.xml**

```kotlin

<Button

        android:id="@+id/buttonSu"

        android:layout_width="match_parent"

        android:layout_height="wrap_content"

        android:layout_marginStart="15dp"

        android:layout_marginEnd="15dp"

        android:layout_marginTop="15dp"

        android:background="#81c147" //버튼 배경색 변경

        android:text="@string/회원가입"

        android:textColor="@color/white" //버튼 글자색 변경

        android:textSize="15sp"

 

        app:layout_constraintTop_toBottomOf="@+id/buttonSi"

        />

```

 

```kotlin

    <EditText //EditText로 입력창 만들기

        android:id="@+id/editPw"

        android:layout_width="match_parent"

        android:layout_marginStart="15dp"

        android:layout_marginEnd="15dp"

        android:layout_height="50dp"

        android:inputType="textPassword" //textPassword로 설정하면 입력한 값이 가려짐

        android:hint="@string/input_pw" //입력창에 메세지 띄워놓기

        android:importantForAutofill="no"

 

        app:layout_constraintTop_toBottomOf="@+id/textview_pw"//원하는 텍스트뷰 아래에 위치할 수 있게 제약 설정

        />

```

 

-**activity_home.xml**

```kotlin

//이미지뷰 사용해서 사진 삽입

 <ImageView

        android:id="@+id/imageView"

        android:layout_width="150dp"

        android:layout_height="150dp"

        android:layout_marginTop="80dp"

        android:src="@drawable/photo" //사진 삽입하기 위해서 drawable 폴더에 사진 파일 넣은 후에 적어주기

        app:layout_constraintEnd_toEndOf="parent"

        app:layout_constraintStart_toStartOf="parent"

        app:layout_constraintTop_toTopOf="parent"

        android:contentDescription="@string/image"

        />

```

 

 

## 3️⃣ 과제를 통해 배운 내용

  💡 `ViewBinding`을 활용해 xlm과 activity를 연결하는 방법을 배웠습니다.<br>

  💡 `intent`를 활용해 다른 activity로 전환하는 방법을 배웠습니다.<br>

  💡 `isEmpty()`를 활용해 EditText에서 입력받은 값에 따라 화면 전환을 다르게 하는 연습을 할 수 있었습니다.

* * *

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
