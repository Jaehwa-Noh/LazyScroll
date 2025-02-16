# LazyScroll
Compose doesn't support scrollbar on lazy composables now days.   
https://developer.android.com/jetpack/androidx/compose-roadmap#core-libraries
![image](https://github.com/user-attachments/assets/fb45f948-c877-42f9-a21c-6fef1fd69008)



So that I made scrollbar for that composables.   
Enjoy your lazy composables with my scrollbar SDK.

Thank you.

## Usage
settings.gradle.kts
```kotlin dsl
pluginManagement {
    repositories {
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
    }
}
```

(module) build.gradle.kts
```kotlin dsl
dependencies {
    implementation("io.github.jaehwa-noh:lazy-scroll:0.0.3-beta")
}
```

In the code
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HowToUseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val lazyListState = rememberLazyListState()
    Box(modifier = modifier) {
        LazyColumn(state = lazyListState) {
            for (index in 0..100) {
                item {
                    Text(
                        text = "Hello $index!",
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
        LazyScrollbarScreen(lazyListState = lazyListState)
    }
}
```

### Spec
Support minSdkVersion >= 21  
Always good to use latest Compose version



## Contribution
Always welcome to your contribution.

<br/>
<br/>

___

<br/>
<br/>

# 레이지스크롤
컴포즈는 현재 스크롤바를 지원하지 않습니다.   
https://developer.android.com/jetpack/androidx/compose-roadmap#core-libraries
![image](https://github.com/user-attachments/assets/e4b2ec39-c7c1-45aa-be9c-62620f498d02)

그래서 만들었습니다.   
당신의 레이지 컴포저블을 제 스크롤바 SDK로 편하게 사용하세요.

## 사용법
settings.gradle.kts
```kotlin dsl
pluginManagement {
    repositories {
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
    }
}
```

(module) build.gradle.kts
```kotlin dsl
dependencies {
    implementation("io.github.jaehwa-noh:lazy-scroll:0.0.3-beta")
}
```

코드에서.
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HowToUseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val lazyListState = rememberLazyListState()
    Box(modifier = modifier) {
        LazyColumn(state = lazyListState) {
            for (index in 0..100) {
                item {
                    Text(
                        text = "Hello $index!",
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
        LazyScrollbarScreen(lazyListState = lazyListState)
    }
}
```

### 스펙
최소 SDK 버전 >= 21 지원  
언제나 최신 컴포즈 버전이 좋습니다.


## 기여
당신의 기여는 언제나 환영합니다.
