# ๐ฑSeminar 1

## 1๏ธโฃ Level 1 ์คํํ๋ฉด

<img src="https://user-images.githubusercontent.com/92876819/162605596-47a039a7-f9e8-4ce7-b699-6d873e55b598.gif" width="200" height="400"/>

 

## 2๏ธโฃ ์ฝ๋ ์ค๋ช

- **SigininActivity.kt**

```kotlin

        val suIntent = Intent(this, SignUpActivity::class.java) //ํ์๊ฐ์ ํ์ด์ง๋ก ์ ํํ๊ธฐ ์ํ indent

        val homeIntent = Intent(this, HomeActivity::class.java) //๋ก๊ทธ์ธ ์ฑ๊ณต ์ ํ ํ์ด์ง๋ก ์ ํํ๊ธฐ ์ํ intent

 

        val etId = binding.editId.text //์์ด๋ ์๋ ฅ์ฐฝ์ ์๋ ฅ๋ ํ์คํธ ์ฐธ์กฐํ๊ธฐ

        val etPw = binding.editPw.text //๋น๋ฒ ์๋ ฅ์ฐฝ์ ์๋ ฅ๋ ํ์คํธ ์ฐธ์กฐํ๊ธฐ

 

        //๋ก๊ทธ์ธ ๋ฒํผ ๋๋ ์ ๋ ์๋ ฅ๊ฐ์ด ์์ผ๋ฉด ๋ฉ์ธ์ง ๋์ฐ๊ธฐ, ์๋๋ผ๋ฉด ํ ํ์ด์ง๋ก ์ด๋

        binding.buttonSi.setOnClickListener {

            if (etId.isEmpty() || etPw.isEmpty()) {

                Toast.makeText(this, "์์ด๋/๋น๋ฐ๋ฒํธ๋ฅผ ํ์ธํด์ฃผ์ธ์", Toast.LENGTH_SHORT).show()

            }else{

                Toast.makeText(this, "๋ก๊ทธ์ธ ์ฑ๊ณต", Toast.LENGTH_SHORT).show()

                startActivity(homeIntent)

            }

        }

        //ํ์๊ฐ์ ๋ฒํผ ๋๋ฅด๋ฉด SignUp ํ์ด์ง๋ก ์ด๋

        binding.buttonSu.setOnClickListener{

            startActivity(suIntent)

        }

```

 

-**SignUpActivity.kt**

```kotlin

        //ํ์๊ฐ์ ์ฑ๊ณตํ๋ฉด ๋ก๊ทธ์ธ ํ์ด์ง๋ก ๋ค์ ์ด๋ํ  ์ ์๋๋ก

        val siIntent = Intent(this, SignInActivity::class.java)

        

        //ํ์คํธ ์๋ ฅ๊ฐ ์ฐธ์กฐ์ฉ

        val eName = binding.EditName.text

        val eId = binding.EditId.text

        val ePw = binding.EditPw.text

 

        //ํ์๊ฐ์ ๋ฒํผ ๋๋ ์ ๋ ์๋ ฅ๊ฐ ์์ผ๋ฉด ๋ฉ์ธ์ง ๋์ฐ๊ธฐ, ๊ฐ์ ์ฑ๊ณต ์ ๋ก๊ทธ์ธ ํ์ด์ง๋ก ์ด๋

        binding.buttonSuCom.setOnClickListener {

            if (eName.isEmpty() || eId.isEmpty() || ePw.isEmpty()) {

                Toast.makeText(this, "์๋ ฅ๋์ง ์์ ์ ๋ณด๊ฐ ์์ต๋๋ค.", Toast.LENGTH_SHORT).show()

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

        android:background="#81c147" //๋ฒํผ ๋ฐฐ๊ฒฝ์ ๋ณ๊ฒฝ

        android:text="@string/ํ์๊ฐ์"

        android:textColor="@color/white" //๋ฒํผ ๊ธ์์ ๋ณ๊ฒฝ

        android:textSize="15sp"

 

        app:layout_constraintTop_toBottomOf="@+id/buttonSi"

        />

```

 

```kotlin

    <EditText //EditText๋ก ์๋ ฅ์ฐฝ ๋ง๋ค๊ธฐ

        android:id="@+id/editPw"

        android:layout_width="match_parent"

        android:layout_marginStart="15dp"

        android:layout_marginEnd="15dp"

        android:layout_height="50dp"

        android:inputType="textPassword" //textPassword๋ก ์ค์ ํ๋ฉด ์๋ ฅํ ๊ฐ์ด ๊ฐ๋ ค์ง

        android:hint="@string/input_pw" //์๋ ฅ์ฐฝ์ ๋ฉ์ธ์ง ๋์๋๊ธฐ

        android:importantForAutofill="no"

 

        app:layout_constraintTop_toBottomOf="@+id/textview_pw"//์ํ๋ ํ์คํธ๋ทฐ ์๋์ ์์นํ  ์ ์๊ฒ ์ ์ฝ ์ค์ 

        />

```

 

-**activity_home.xml**

```kotlin

//์ด๋ฏธ์ง๋ทฐ ์ฌ์ฉํด์ ์ฌ์ง ์ฝ์

 <ImageView

        android:id="@+id/imageView"

        android:layout_width="150dp"

        android:layout_height="150dp"

        android:layout_marginTop="80dp"

        android:src="@drawable/photo" //์ฌ์ง ์ฝ์ํ๊ธฐ ์ํด์ drawable ํด๋์ ์ฌ์ง ํ์ผ ๋ฃ์ ํ์ ์ ์ด์ฃผ๊ธฐ

        app:layout_constraintEnd_toEndOf="parent"

        app:layout_constraintStart_toStartOf="parent"

        app:layout_constraintTop_toTopOf="parent"

        android:contentDescription="@string/image"

        />

```

 

 

## 3๏ธโฃ ๊ณผ์ ๋ฅผ ํตํด ๋ฐฐ์ด ๋ด์ฉ

  ๐ก `ViewBinding`์ ํ์ฉํด xlm๊ณผ activity๋ฅผ ์ฐ๊ฒฐํ๋ ๋ฐฉ๋ฒ์ ๋ฐฐ์ ์ต๋๋ค.<br>

  ๐ก `intent`๋ฅผ ํ์ฉํด ๋ค๋ฅธ activity๋ก ์ ํํ๋ ๋ฐฉ๋ฒ์ ๋ฐฐ์ ์ต๋๋ค.<br>

  ๐ก `isEmpty()`๋ฅผ ํ์ฉํด EditText์์ ์๋ ฅ๋ฐ์ ๊ฐ์ ๋ฐ๋ผ ํ๋ฉด ์ ํ์ ๋ค๋ฅด๊ฒ ํ๋ ์ฐ์ต์ ํ  ์ ์์์ต๋๋ค.

* * *

# ๐ฑSeminar 2
## 1๏ธโฃ Level 1 ์คํํ๋ฉด
<img src="https://user-images.githubusercontent.com/92876819/164729685-90c1f660-099e-49ca-b70c-64cd04fe523c.gif" width="200" height="400"/>

## 2๏ธโฃ ์ฝ๋ ์ค๋ช
### **1. Fragment ๋ง๋ค๊ธฐ**
  - ์ด๋ฒ ๊ณผ์ ์์๋ repository_fragment, follower_fragment ํ์
 
#### fragment_follower.xml
```kotlin
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    tools:context=".FollowerFragment">

    <androidx.recyclerview.widget.RecyclerView #๋ฆฌ์ฌ์ดํด๋ฌ๋ทฐ ๋ ์ด์์ 
        android:id="@+id/rv_Follower"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager" #LayoutManager ํด๋์ค๋ฅผ ๋ถ๋ฌ ์ํ๋ ํํ ์ ํ(ํ๋ก์๋ ์ ํ์ผ๋ก ์ ํ)
        tools:itemCount="6" #๋ณด์ฌ์ค ๋ฐ์ดํฐ ๊ฐ์ 
        tools:listitem="@layout/follower_list" /> #ํ๋ก์ ๋ฆฌ์คํธ ๋ ์ด์์ ์ฌ์ฉ

```
#### FollowerFragment.kt
```kotlin
class FollowerFragment : Fragment() {

    private lateinit var followerAdapter: FollowerAdapter
    private var _binding : FragmentFollowerBinding? = null #nullableํ ๋ณ์๋ก ์ ์ธ(๋ฉ๋ชจ๋ฆฌ ๋์ ๋ฐฉ์ง)
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

#๋ง๋  ํ๋ก์ ๋ฐ์ดํฐ ํด๋์ค ํ์์ ์ํ๋ ๋ฐ์ดํฐ๋ฅผ ์๋ ฅ
            followerAdapter.followerList.addAll(
                listOf(
                    FollowerData("์์ง์", "7์กฐ"),
                    FollowerData("์ดํ๋น", "7์กฐ"),
                    FollowerData("์ ์ง๋ฏผ", "7์กฐ"),
                    FollowerData("์ ์ง์ฐ", "7์กฐ"),
                    FollowerData("์กฐ์ฌํ", "7์กฐ")
                )
            )
            followerAdapter.notifyDataSetChanged()
    }

#๋ฉ๋ชจ๋ฆฌ ๋์ ๋ฐฉ์ง๋ฅผ ์ํด binding ๊ฐ์ฒด ์ฐธ์กฐ ํด์ 
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
}
```
 

- #### follower_list.xml
  - ๋ฐ์ดํฐ๋ฅผ ์ด๋ป๊ฒ ๋ด์์ง ๋ ์ด์์ ์ค์ ํด์ฃผ๊ธฐ
  - ์ฌ์ฌ์ฉ๋๋ ๋ ์ด์์

- #### FollowerData.kt
- ํ๋ก์์ ๊ด๋ จ๋ ์ด๋ค ์ ๋ณด๋ฅผ ๊ณตํต์ ์ผ๋ก ๋ด์์ง ์ ์ด๋์ ํด๋์ค
```kotlin
data class FollowerData(
    val name : String,
    val introduce : String
)
```
#### FollowerAdapter.kt
  - Adapter์ ViewHolder๋ฅผ ๋ด๊ณ  ์์
  - Adapter๋ onCreateViewHolder, onBindViewHolder, getItemCount๋ฅผ override ํด์ฃผ์ด์ผ ํ๋ค.
  - nested ๊ตฌ์กฐ๋ก ViewHolder ํด๋์ค๋ ๊ฐ์ง๊ณ  ์๋ค.

```kotlin
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding =
            FollowerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) { #ViewHolder๊ฐ ๊ฐ์ง ๋ทฐ์ Adapter๋ก๋ถํฐ ์ ๋ฌ๋ฐ์ ๋ฐ์ดํฐ ์ ๋ฌ
        holder.onBind(followerList[position])
    }

    override fun getItemCount(): Int = followerList.size

``` 

```kotlin
class FollowerViewHolder(
        private val binding : FollowerListBinding
    ) : RecyclerView.ViewHolder(binding.root) { #์ฌํ์ฉํ  ๋ ์ด์์์ ๋ฃจํธ๋ทฐ๋ฅผ ๋๊ฒจ์ค๋ค.
        fun onBind(data : FollowerData) {
            binding.tvName.text = data.name
            binding.tvIntroduction.text = data.introduce
        }
```


#### HomeActivity.kt
  - ์ฒ์์ ๋ฑ์ฅํ๋ ๋ทฐ๊ฐ ํ๋ก์์์ด๋๋ก fragment1์ FollowerFragment()๋ก ์ค์   

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

## 3๏ธโฃ ๊ณผ์ ๋ฅผ ํตํด ๋ฐฐ์ด ๋ด์ฉ
  ๐ก ViewHolder๋ฅผ ํ์ฉํด ํธ๋ฆฌํ๊ฒ ๋ฐ๋ณต๋๋ ๋ ์ด์์์ ์ฌ์ฌ์ฉํ๊ธฐ<br>
  ๐ก ์ฌ๋ฌ ๊ฐ์ fragment ์ ํํ๊ธฐ<br>
  ๐ก Fragment View์ ์๋ช์ฃผ๊ธฐ๊ฐ Fragmnet์ ์๋ช์ฃผ๊ธฐ๋ณด๋ค ์งง๊ธฐ ๋๋ฌธ์ ๋ฐ์ํ  ์ ์๋ ๋ฉ๋ชจ๋ฆฌ ๋์ ๋ฐฉ์งํ๋ ๋ฐฉ๋ฒ(binding ํ์ฉ) 

* * *

# ๐ฑSeminar 3<br>

## 1๏ธโฃ Level 1 ์คํํ๋ฉด

<img src="https://user-images.githubusercontent.com/92876819/167154544-abf11337-1b00-4b9d-b2e0-ce68a2035a4f.gif" width="200" height="400"/>



## 2๏ธโฃ ์ฝ๋ ์ค๋ช

### **1. Profile Fragment**

 

#### profile_fragment.xml

```kotlin

   <androidx.appcompat.widget.AppCompatButton //์๊น ๋ณํ ์ฃผ๊ธฐ ์ํด์

    android:id="@+id/btn_repository"
    android:layout_width="163dp"
    android:layout_height="wrap_content"
    android:text="@string/repo_list"
    android:layout_marginTop="44dp"
    android:background="@drawable/select_btn"
    android:textColor="@color/selector_bottom_navi"//์๊น ๋ณํ ์ค์ 
    android:fontFamily="@font/noto_sans_kr_medium" //ํฐํธ ์ ์ฉ
    android:paddingStart="34dp"// padding ์ด์ฉํด์ ๋์์ธํ๊ธฐ
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

    binding.btnFollower.isSelected = true //์ฒ์์ ํ๋ก์ ๋ฒํผ์ด ์ ํ๋์ด ์๋๋ก ์ค์ 
    binding.btnRepository.isSelected = false
    initTransactionFragment()
    initImage()

    return binding.root
}

private fun initImage() {
    Glide.with(this)
        .load(R.drawable.photo)
        .circleCrop()//์ฌ์ง ์ ๋ชจ์์ผ๋ก ๋ง๋ค๊ธฐ
        .into(binding.ivPhoto)
}
```

 ```kotlin

private fun initTransactionFragment() {
    val fragment1 = FollowerFragment()
    val fragment2 = RepositoryFragment()

    childFragmentManager.beginTransaction().add(R.id.fragment_profile, fragment1).commit() //fragment ์์์ ๋๋ค๋ฅธ fragment ์ ํ์ ํ๋ ค๋ฉด support์ด ์๋ childFragmentManager ์ฌ์ฉ
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

  - TabLayout, ViewPager2 ์ ์ฉํ๊ธฐ



- #### fragment_home.xml

```kotlin

<com.google.android.material.tabs.TabLayout
    android:id="@+id/tl_fragment_home"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:layout_constraintTop_toBottomOf="@+id/tv_github"
    app:tabIndicatorColor="@color/purple_200" //์ธ๋์ผ์ดํฐ ์์ ์ค์ 
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



## 3๏ธโฃ ๊ณผ์ ๋ฅผ ํตํด ๋ฐฐ์ด ๋ด์ฉ

  ๐ก Fragment ๊น๋ํ๊ฒ ๊ด๋ฆฌํ๊ธฐ<br>

  ๐ก Fragment ์์ Fragment๋ฅผ ์ ํํ๊ธฐ ์ํด childFragmentManager ์ฌ์ฉํ๊ธฐ<br>

  ๐ก figma์์ ์ฃผ์ด์ง ์ ๋ณด๋ฅผ ํ์ฉํด padding, margin ๋ฑ์ ์ค์ ํด์ ๋์์ธํ๋ ์ฐ์ต

* * *

# ๐ฑSeminar 4<br>

๐ฆ ๋ทฐํ์ด์ ๊ฐ ์ ์ฉ ์ ๋ ๋ถ๋ถ์ ๊ณผ์ ๋ฅผ ํ๋๋ฐ ๋ฆฌ๋๋ฏธ๋ ํจ๊ป ์์ ํ๊ฒ ์ต๋๋ค!
    ์ฑ์ฅ๊ณผ์ ๋ ๊ณง ์ฌ๋ฆฌ๊ฒ ์ต๋๋ค,,
    

## 1๏ธโฃ ์คํํ๋ฉด
|LEVEL 1|||
|:------:|:---:|:---:|
|<img src="https://user-images.githubusercontent.com/92876819/168263042-856f36cc-3fa2-469a-a104-fc07ab7935c8.gif" width="200" height="400"/>|<img src = "https://user-images.githubusercontent.com/92876819/168263232-c1d98aa5-62b5-471f-81ca-3fe3bbec160a.gif" width="200" height="400"/>||
|ํ์๊ฐ์ |๋ก๊ทธ์ธ||


## 2๏ธโฃ ์ฝ๋ ์ค๋ช
### **1. ๋ก๊ทธ์ธ**<br>
#### **POSTMAN์ผ๋ก Request์ ๋ํ Response Body ๊ฐ ํ์ธ**<br>
<img src="https://user-images.githubusercontent.com/92876819/168266220-ba656c3b-aeeb-4bbb-ad31-c3d9036dea00.PNG" width="400" height="300"/><br><br>

#### **JSON ๊ฐ ์ฐธ๊ณ ํด์ ๋ฐ์ดํฐ ํด๋์ค ๋ง๋ค์ด์ฃผ๊ธฐ**
- **RequestSignIn.kt**
```kotlin
data class RequestSignIn (
    @SerializedName("email") //Json ํค๊ฐ๊ณผ ๋ฐ์ดํฐ ํด๋์ค ๋ณ์๋ช์ ๋ค๋ฅด๊ฒ ํ  ๋
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

### **2. ํ์๊ฐ์**
#### **POSTMAN์ผ๋ก Request์ ๋ํ Response Body ๊ฐ ํ์ธ**<br>
<img src="https://user-images.githubusercontent.com/92876819/168267203-4fc3faa9-5e87-4921-9207-8ccdc1665c54.PNG" width="400" height="300"/><br><br>

#### **JSON ๊ฐ ์ฐธ๊ณ ํด์ ๋ฐ์ดํฐ ํด๋์ค ๋ง๋ค์ด์ฃผ๊ธฐ**
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

### **3. Retrofit Interface ์ค๊ณ**
- **SoptService.kt**
```kotlin
interface SoptService {
    @POST("auth/signin")//๋ก๊ทธ์ธ
    fun postLogin(
        @Body body: RequestSignIn//์ด๋ธํ์ด์์ผ๋ก Requestbody ๋ฐ์ดํฐ ๋ฃ์ด์ฃผ๊ธฐ
    ): Call<ResponseSignIn>//Response๊ฐ ๊ฐ์ฒด๊ฐ Json Object๋ผ์ Call<>ํํ

    @POST("auth/signup")//ํ์๊ฐ์
    fun postSignUp(
        @Body body: RequestSignUp
    ): Call<ResponseSignUp>
}
```

### **4. Retrofit Interface ์ค์  ๊ตฌํ์ฒด**
- **ServiceCreator.kt**
```kotlin
object ServiceCreator {
    private const val BASE_URL = "http://13.124.62.236/"

    private val retrofit: Retrofit = Retrofit.Builder()//retrofit ๊ฐ์ฒด ์์ฑ
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val soptService: SoptService = retrofit.create(SoptService::class.java)//create๋ก ๋๊ฒจ์ ์ค์  ๊ตฌํ์ฒด ์์ฑ
}
```
### **5. CallBack ๋ฑ๋กํด์ ํต์  ์์ฒญ**
- ๋ก๊ทธ์ธ๊ณผ ํ์๊ฐ์ ํ์ด์ง์์ ํต์  ์์ฒญํ  ์ ์๋๋ก CallBack ๋ฑ๋กํ๊ธฐ<br><br>

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
                        "${data?.email}๋ ๋ฐ๊ฐ์ต๋๋ค!",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                } else Toast.makeText(this@SignInActivity, "๋ก๊ทธ์ธ์ ์คํจํ์จ์ต๋๋ค.", Toast.LENGTH_SHORT)
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
                        "ํ์๊ฐ์ ์ฑ๊ณต!",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
                } else Toast.makeText(this@SignUpActivity, "ํ์๊ฐ์์ ์คํจํ์ต๋๋ค.", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ResponseSignUp>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }
        }

        )


    }
```

## 3๏ธโฃ ๊ณผ์ ๋ฅผ ํตํด ๋ฐฐ์ด ๋ด์ฉ

  ๐ก POSTMAN์ผ๋ก ์๋ฒํต์  ํด๋ณด๊ณ  Request/Response ๊ฐ์ฒด ์ค๊ณํ๊ธฐ<br>

  ๐ก ๋๊ธฐ์ ๋น๋๊ธฐ์ ์ฐจ์ด์ ์๋ฒ ํต์ ์์ ๋น๋๊ธฐ๋ฅผ ์ฌ์ฉํ๋ ์ด์ (ANR ๋ฐฉ์ง)<br>

  ๐ก Callback ๋ฑ๋กํด์ ๋น๋๊ธฐ ์์ ์ดํ ํ๋ ์ง์ ํ๊ธฐ