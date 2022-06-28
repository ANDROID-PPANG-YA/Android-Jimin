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

* * *

# 🌱Seminar 3<br>

## 1️⃣ Level 1 실행화면

<img src="https://user-images.githubusercontent.com/92876819/167154544-abf11337-1b00-4b9d-b2e0-ce68a2035a4f.gif" width="200" height="400"/>



## 2️⃣ 코드 설명

### **1. Profile Fragment**

 

#### profile_fragment.xml

```kotlin

   <androidx.appcompat.widget.AppCompatButton //색깔 변화 주기 위해서

    android:id="@+id/btn_repository"
    android:layout_width="163dp"
    android:layout_height="wrap_content"
    android:text="@string/repo_list"
    android:layout_marginTop="44dp"
    android:background="@drawable/select_btn"
    android:textColor="@color/selector_bottom_navi"//색깔 변화 설정
    android:fontFamily="@font/noto_sans_kr_medium" //폰트 적용
    android:paddingStart="34dp"// padding 이용해서 디자인하기
    android:paddingEnd="35dp"
    android:paddingTop="13dp"
    android:paddingBottom="13dp"
    app:layout_constraintStart_toEndOf="@id/btn_follower"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintTop_toBottomOf="@id/tv_instagram"
    />
```

#### ProfileFragment.kt

```kotlin

_binding = FragmentProfileBinding.inflate(layoutInflater,container,false)

    binding.btnFollower.isSelected = true //처음에 팔로워 버튼이 선택되어 있도록 설정
    binding.btnRepository.isSelected = false
    initTransactionFragment()
    initImage()

    return binding.root
}

private fun initImage() {
    Glide.with(this)
        .load(R.drawable.photo)
        .circleCrop()//사진 원 모양으로 만들기
        .into(binding.ivPhoto)
}
```

 ```kotlin

private fun initTransactionFragment() {
    val fragment1 = FollowerFragment()
    val fragment2 = RepositoryFragment()

    childFragmentManager.beginTransaction().add(R.id.fragment_profile, fragment1).commit() //fragment 안에서 또다른 fragment 전환을 하려면 support이 아닌 childFragmentManager 사용
```
```kotlin
binding.btnRepository.setOnClickListener {
    val transaction = childFragmentManager.beginTransaction()
    binding.btnRepository.isSelected = true
    binding.btnFollower.isSelected = false
    transaction.replace(R.id.fragment_profile, fragment2)
    transaction.commit()
}
```


### **2. Home Fragment**

  - TabLayout, ViewPager2 적용하기



- #### fragment_home.xml

```kotlin

<com.google.android.material.tabs.TabLayout
    android:id="@+id/tl_fragment_home"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:layout_constraintTop_toBottomOf="@+id/tv_github"
    app:tabIndicatorColor="@color/purple_200" //인디케이터 색상 설정
    />

<androidx.viewpager2.widget.ViewPager2
    android:id="@+id/vp_fragment_home"
    android:layout_width="match_parent"
    android:layout_height="0dp"
    android:paddingTop="156dp"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintTop_toBottomOf="@id/tl_fragment_home"
    />
```



## 3️⃣ 과제를 통해 배운 내용

  💡 Fragment 깔끔하게 관리하기<br>

  💡 Fragment 안의 Fragment를 전환하기 위해 childFragmentManager 사용하기<br>

  💡 figma에서 주어진 정보를 활용해 padding, margin 등을 설정해서 디자인하는 연습

* * *

# 🌱Seminar 4<br>

💦 뷰페이저가 적용 안 된 부분에 과제를 했는데 리드미랑 함께 수정하겠습니다!
    성장과제도 곧 올리겠습니다,,
    

## 1️⃣ 실행화면
|LEVEL 1|||
|:------:|:---:|:---:|
|<img src="https://user-images.githubusercontent.com/92876819/168263042-856f36cc-3fa2-469a-a104-fc07ab7935c8.gif" width="200" height="400"/>|<img src = "https://user-images.githubusercontent.com/92876819/168263232-c1d98aa5-62b5-471f-81ca-3fe3bbec160a.gif" width="200" height="400"/>||
|회원가입 |로그인||


## 2️⃣ 코드 설명
### **1. 로그인**<br>
#### **POSTMAN으로 Request에 대한 Response Body 값 확인**<br>
<img src="https://user-images.githubusercontent.com/92876819/168266220-ba656c3b-aeeb-4bbb-ad31-c3d9036dea00.PNG" width="400" height="300"/><br><br>

#### **JSON 값 참고해서 데이터 클래스 만들어주기**
- **RequestSignIn.kt**
```kotlin
data class RequestSignIn (
    @SerializedName("email") //Json 키값과 데이터 클래스 변수명을 다르게 할 때
    val id: String,
    val password: String
    )
```
- **ResponseSignIn.kt**
```kotlin
data class ResponseSignIn(
    val status: Int,
    val message: String,
    val data: Data
) {
    data class Data(
        val name: String,
        val email: String
    )
}
```

### **2. 회원가입**
#### **POSTMAN으로 Request에 대한 Response Body 값 확인**<br>
<img src="https://user-images.githubusercontent.com/92876819/168267203-4fc3faa9-5e87-4921-9207-8ccdc1665c54.PNG" width="400" height="300"/><br><br>

#### **JSON 값 참고해서 데이터 클래스 만들어주기**
- **RequestSignUp.kt**
```kotlin
data class RequestSignUp(
    val name: String,
    @SerializedName("email")
    val id: String,
    val password: String
)
```
- **ResponseSignUp.kt**
```kotlin
data class ResponseSignUp(
    val status: Int,
    val message: String,
    val data: Data
) {
    data class Data(
        val id: Int
    )
}
```

### **3. Retrofit Interface 설계**
- **SoptService.kt**
```kotlin
interface SoptService {
    @POST("auth/signin")//로그인
    fun postLogin(
        @Body body: RequestSignIn//어노테이션으로 Requestbody 데이터 넣어주기
    ): Call<ResponseSignIn>//Response가 객체가 Json Object라서 Call<>형태

    @POST("auth/signup")//회원가입
    fun postSignUp(
        @Body body: RequestSignUp
    ): Call<ResponseSignUp>
}
```

### **4. Retrofit Interface 실제 구현체**
- **ServiceCreator.kt**
```kotlin
object ServiceCreator {
    private const val BASE_URL = "http://13.124.62.236/"

    private val retrofit: Retrofit = Retrofit.Builder()//retrofit 객체 생성
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val soptService: SoptService = retrofit.create(SoptService::class.java)//create로 넘겨서 실제 구현체 생성
}
```
### **5. CallBack 등록해서 통신 요청**
- 로그인과 회원가입 페이지에서 통신 요청할 수 있도록 CallBack 등록하기<br><br>

- **SignInActivity.kt**
```kotlin
    private fun loginNetwork() {
        val requestSignIn = RequestSignIn(
            id = binding.editId.text.toString(),
            password = binding.editPw.text.toString()
        )

        val call: Call<ResponseSignIn> = ServiceCreator.soptService.postLogin(requestSignIn)

        call.enqueue(object : Callback<ResponseSignIn> {
            override fun onResponse(
                call: Call<ResponseSignIn>,
                response: Response<ResponseSignIn>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data

                    Toast.makeText(
                        this@SignInActivity,
                        "${data?.email}님 반갑습니다!",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                } else Toast.makeText(this@SignInActivity, "로그인에 실패하셨습니다.", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onFailure(call: Call<ResponseSignIn>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }
        })

    }
```

- **SignUpActivity.kt**
```kotlin
private fun signupNetwork() {
        val requestSignUp = RequestSignUp(
            name = binding.EditName.text.toString(),
            id = binding.EditId.text.toString(),
            password = binding.EditPw.text.toString()
        )

        val call: Call<ResponseSignUp> = ServiceCreator.soptService.postSignUp(requestSignUp)

        call.enqueue(object : Callback<ResponseSignUp> {
            override fun onResponse(
                call: Call<ResponseSignUp>,
                response: Response<ResponseSignUp>
            ) {
                if(response.isSuccessful) {

                    Toast.makeText(
                        this@SignUpActivity,
                        "회원가입 성공!",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
                } else Toast.makeText(this@SignUpActivity, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ResponseSignUp>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }
        }

        )


    }
```

## 3️⃣ 과제를 통해 배운 내용

  💡 POSTMAN으로 서버통신 해보고 Request/Response 객체 설계하기<br>

  💡 동기와 비동기의 차이와 서버 통신에서 비동기를 사용하는 이유(ANR 방지)<br>

  💡 Callback 등록해서 비동기 작업 이후 행동 지정하기