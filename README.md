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
