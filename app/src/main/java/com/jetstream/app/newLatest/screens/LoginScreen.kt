package com.jetstream.app.newLatest.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetstream.app.R
import com.jetstream.app.ui.theme.ZenceyNewTheme

@Composable
fun LoginScreen() {

    // ✅ State (ONLY ONCE)
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // ✅ Font family (fixed mapping)
    val fontF = FontFamily(
        Font(R.font.acid_grotesk_bold, FontWeight.Normal),
        Font(R.font.acid_grotesk_medium, FontWeight.Bold)
    )
    val fontFNormal = FontFamily(
        Font(R.font.acid_grotesk_normal, FontWeight.Normal),
        Font(R.font.acid_grotesk_light, FontWeight.Bold)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo), modifier = Modifier.size(120.dp),
            contentDescription = "App Logo"
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Login",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = fontF
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Enter your email & password to login",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Gray,
            fontFamily = fontFNormal
        )

        Spacer(modifier = Modifier.height(40.dp))

        // ✅ Email Field
        CustomField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            placeholder = "Enter your email",
            fontFamily = fontFNormal
        )

        Spacer(modifier = Modifier.height(20.dp))



        CustomPassField(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            placeholder = "Enter your password",
            fontFamily = fontFNormal
        )
        Text(
            text = "Forgot Password?",
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            textAlign = TextAlign.End,
            fontFamily = fontFNormal
        )

        Button(
            onClick = {
                // Handle login
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
    }
}

@Composable
fun CustomField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    fontFamily: FontFamily
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5F5), RoundedCornerShape(12.dp))
            .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
            .padding(14.dp)
    ) {

        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.Gray,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Light
        )

        Spacer(modifier = Modifier.height(4.dp))

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            textStyle = androidx.compose.ui.text.TextStyle(
                fontSize = 16.sp,
                fontFamily = fontFamily
            ),
            decorationBox = { innerTextField ->
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        color = Color.LightGray,
                        fontFamily = fontFamily,
                        fontSize = 16.sp
                    )
                }
                innerTextField()
            }
        )
    }
}


@Composable
fun CustomPassField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    fontFamily: FontFamily
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5F5), RoundedCornerShape(12.dp))
            .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
            .padding(14.dp)
    ) {

        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.Gray,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Light
        )


        var password by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }


//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//
//        ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            // 👇 Text input
            BasicTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.weight(1f),
                singleLine = true,

                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = fontFamily
                ),
                visualTransformation = if (passwordVisible)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),

                decorationBox = { innerTextField ->
                    if (password.isEmpty()) {
                        Text(
                            "Enter your password",
                            color = Color.LightGray,
                            fontWeight = FontWeight.Normal,
                            fontFamily = fontFamily
                        )
                    }
                    innerTextField()
                }
            )

            // 👁 Eye Icon
            IconButton(
                onClick = { passwordVisible = !passwordVisible }, modifier = Modifier.size(30.dp)
            ) {
                Icon(
                    imageVector = if (passwordVisible)
                        Icons.Default.Visibility
                    else
                        Icons.Default.VisibilityOff,
                    contentDescription = null, modifier = Modifier.size(24.dp)
                )
            }

        }
    }
}

@Composable
fun PasswordField() {

    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        modifier = Modifier.fillMaxWidth(),

        // 👇 Show / Hide password
        visualTransformation = if (passwordVisible)
            VisualTransformation.None
        else
            PasswordVisualTransformation(),

        trailingIcon = {
            val icon = if (passwordVisible)
                Icons.Default.Visibility
            else
                Icons.Default.VisibilityOff

            IconButton(onClick = {
                passwordVisible = !passwordVisible
            }) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Toggle Password"
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewLogin() {
    ZenceyNewTheme {
        LoginScreen()
    }
}